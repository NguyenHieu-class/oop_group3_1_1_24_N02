package com.mycompany.app;

// Định nghĩa giao diện Signal
public interface Signal {
    // Phương thức lấy biên độ của tín hiệu
    double getAmplitude();
    
    // Phương thức lấy tần số của tín hiệu
    double getFrequency();
    
    // Phương thức lấy chu kỳ của tín hiệu
    double getPeriod();
    
    // Phương thức lấy bước sóng của tín hiệu
    double getWavelength();
    
    // Phương thức hiển thị thông tin tín hiệu
    void displaySignalInfo();
}

