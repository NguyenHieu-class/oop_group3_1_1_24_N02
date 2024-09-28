bool FileSystem::directoryExists(const string &path)
{
    DWORD attribs = GetFileAttributes(path.c_str());
    if (attribs == INVALID_FILE_ATTRIBUTES)
    {
        // Đường dẫn không tồn tại
        return false;
    }

    // Kiểm tra xem đây có phải là một directory không
    return (attribs & FILE_ATTRIBUTE_DIRECTORY);
}

bool FileSystem::newFile(const string path, const string name)
{
    // Kiểm tra xem đường dẫn có tồn tại không
    if (!directoryExists(path))
    {
        cout << "Directory does not exist: " << path << endl;
        return false;
    }

    // Kiểm tra xem file đã tồn tại hay chưa
    if (GetFileAttributes((path + name).c_str()) != INVALID_FILE_ATTRIBUTES)
    {
        cout << "File already exists: " << path + name << endl;
        return false;
    }

    // Tạo file mới nếu chưa tồn tại
    HANDLE newFile = CreateFileA(
        (path + name).c_str(),
        GENERIC_READ | GENERIC_WRITE,
        FILE_SHARE_DELETE | FILE_SHARE_READ | FILE_SHARE_WRITE,
        nullptr,
        CREATE_NEW,
        FILE_ATTRIBUTE_NORMAL,
        nullptr);
    
    if (newFile == INVALID_HANDLE_VALUE)
    {
        cout << "Failed to create file: " << path + name << endl;
        return false;
    }

    // Đóng handle sau khi tạo file
    CloseHandle(newFile);
    return true;
}

bool FileSystem::newFolder(const string path, const string name)
{
    // Kiểm tra xem đường dẫn có tồn tại không
    if (!directoryExists(path))
    {
        cout << "Directory does not exist: " << path << endl;
        return false;
    }

    // Kiểm tra xem folder đã tồn tại hay chưa
    if (GetFileAttributes((path + name + '\\').c_str()) != INVALID_FILE_ATTRIBUTES)
    {
        cout << "Folder already exists: " << path + name << endl;
        return false;
    }

    // Tạo folder mới nếu chưa tồn tại
    if (!CreateDirectory((path + name + '\\').c_str(), NULL))
    {
        cout << "Failed to create folder: " << path + name << endl;
        return false;
    }

    return true;
}
