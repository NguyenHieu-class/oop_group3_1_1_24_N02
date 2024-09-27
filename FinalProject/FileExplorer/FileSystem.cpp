#include "FileSystem.h"
#include <Windows.h>
#include <vector>
#include <string>
#include <Shlobj.h> // For SHFileOperation

// Hàm chuyển đổi std::string sang std::wstring
std::wstring stringToWString(const std::string& str)
{
    int size_needed = MultiByteToWideChar(CP_UTF8, 0, str.c_str(), (int)str.size(), NULL, 0);
    std::wstring wstr(size_needed, 0);
    MultiByteToWideChar(CP_UTF8, 0, str.c_str(), (int)str.size(), &wstr[0], size_needed);
    return wstr;
}

bool FileSystem::remove(const std::string path)
{
    std::wstring wpath = stringToWString(path);  // Chuyển đổi sang wstring

    if (wpath[wpath.length() - 1] != L'\\')  // Ký tự rộng cho chuỗi rộng
    {
        return DeleteFileW(wpath.c_str());  // Sử dụng DeleteFileW cho chuỗi rộng
    }

    std::wstring dir = wpath;
    dir.pop_back();
    dir.push_back(L'\0');
    dir.push_back(L'\0');

    SHFILEOPSTRUCTW file_op = {
        NULL,
        FO_DELETE,
        dir.c_str(),
        L"",  // Sử dụng chuỗi rộng
        FOF_NOCONFIRMATION |
        FOF_NOERRORUI |
        FOF_SILENT,
        false,
        0,
        L""  // Chuỗi rộng
    };

    return !SHFileOperationW(&file_op);  // Sử dụng SHFileOperationW cho chuỗi rộng
}

bool FileSystem::rename(const std::string oldPath, const std::string newName)
{
    std::wstring woldPath = stringToWString(oldPath);  // Chuyển đổi sang chuỗi rộng
    std::wstring wnewPath = stringToWString(oldPath.substr(0, oldPath.find_last_of('\\', oldPath.length() - 2) + 1) + newName);

    if (oldPath[oldPath.length() - 1] == '\\')
    {
        wnewPath += L'\\';
    }
    else
    {
        wnewPath += stringToWString(oldPath.substr(oldPath.find_last_of('.'))); // Thêm đuôi file
    }
    return MoveFileW(woldPath.c_str(), wnewPath.c_str());  // Sử dụng MoveFileW
}

bool FileSystem::move(const std::string source, const std::string destination)
{
    std::wstring wsource = stringToWString(source);
    std::wstring wdestination = stringToWString(destination);

    if (wsource[wsource.length() - 1] != L'\\')
    {
        return MoveFileW(wsource.c_str(), (wdestination + wsource.substr(wsource.find_last_of(L'\\', wsource.length() - 2))).c_str());
    }

    std::wstring dir = wsource;
    dir.pop_back();

    SHFILEOPSTRUCTW file_op = {
        NULL,
        FO_MOVE,
        dir.c_str(),
        wdestination.c_str(),
        FOF_NOCONFIRMATION |
        FOF_NOERRORUI |
        FOF_SILENT,
        false,
        0,
        L""
    };

    return !SHFileOperationW(&file_op);
}

bool FileSystem::copy(const std::string source, const std::string destination)
{
    std::wstring wsource = stringToWString(source);
    std::wstring wdestination = stringToWString(destination);

    if (wsource[wsource.length() - 1] != L'\\')
    {
        std::wstring desti = wdestination + wsource.substr(wsource.find_last_of(L'\\') + 1);
        return CopyFileW(wsource.c_str(), desti.c_str(), TRUE);
    }

    std::wstring dir = wsource;
    dir.pop_back();

    SHFILEOPSTRUCTW file_op = {
        NULL,
        FO_COPY,
        dir.c_str(),
        wdestination.c_str(),
        FOF_NOCONFIRMATION |
        FOF_NOERRORUI |
        FOF_SILENT,
        false,
        0,
        L""
    };

    return !SHFileOperationW(&file_op);
}

bool FileSystem::newFile(const std::string path, const std::string name)
{
    std::wstring wpath = stringToWString(path + name);

    HANDLE newFile = CreateFileW(
        wpath.c_str(),
        GENERIC_READ | GENERIC_WRITE,
        FILE_SHARE_DELETE | FILE_SHARE_READ | FILE_SHARE_WRITE,
        nullptr,
        CREATE_NEW,
        FILE_ATTRIBUTE_NORMAL,
        nullptr);

    if (newFile == INVALID_HANDLE_VALUE)
    {
        return false;
    }
    CloseHandle(newFile);
    return true;
}

bool FileSystem::newFolder(const std::string path, const std::string name)
{
    std::wstring wpath = stringToWString(path + name + '\\');
    return CreateDirectoryW(wpath.c_str(), NULL);
}

std::vector<std::string> FileSystem::getDirectoriesList(const std::string& path)
{
    std::vector<std::string> filesList;
    std::wstring wpath = stringToWString(path);

    DWORD attribute = GetFileAttributesW(wpath.c_str());
    if (attribute & FILE_ATTRIBUTE_DIRECTORY)
    {
        WIN32_FIND_DATAW findFileData;
        HANDLE findFileHandle = FindFirstFileW((wpath + L'*').c_str(), &findFileData);
        if (findFileHandle != INVALID_HANDLE_VALUE)
        {
            do
            {
                if ((findFileData.dwFileAttributes & FILE_ATTRIBUTE_HIDDEN) == 0 && findFileData.cFileName[0] != L'.')
                {
                    if (findFileData.dwFileAttributes & FILE_ATTRIBUTE_DIRECTORY)
                    {
                        filesList.push_back(std::string(findFileData.cFileName, findFileData.cFileName + wcslen(findFileData.cFileName)));
                    }
                }
            } while (FindNextFileW(findFileHandle, &findFileData));
            FindClose(findFileHandle);
        }
    }
    return filesList;
}

std::vector<std::string> FileSystem::getDrivesList()
{
    std::vector<std::string> filesList;

    wchar_t drivesBuf[200];
    DWORD bufSize = 200;
    DWORD stringsSize = GetLogicalDriveStringsW(bufSize, drivesBuf);

    DWORD pos = 0;
    wchar_t tempBuf[50];
    int tempPos = 0;

    while (pos < stringsSize)
    {
        tempBuf[tempPos] = drivesBuf[pos];
        if (tempBuf[tempPos] == L'\0')
        {
            filesList.push_back(std::string(tempBuf, tempBuf + wcslen(tempBuf)));
            tempPos = 0;
        }
        else
        {
            ++tempPos;
        }
        ++pos;
    }

    return filesList;
}
