bool FileSystem::newFile(const string path, const string name)
{
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
        CREATE_NEW,  // Chỉ tạo file mới, nếu đã tồn tại thì trả về lỗi
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
