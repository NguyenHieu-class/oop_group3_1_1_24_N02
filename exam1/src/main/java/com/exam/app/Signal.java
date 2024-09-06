package com.exam.app;

public interface Signal {
    double getAmplitude(); // Biên độ
    double getPeriod(); // Chu kỳ
    double getFrequency(); // Tần số
    double getWavelength(); // Bước sóng
    double getValue(double time);

    // In thông tin nếu cần
    void printInfo();
}
