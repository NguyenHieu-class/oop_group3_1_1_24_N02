package com.exam.app;

public interface Signal {
    double getAmplitude();
    double getPeriod();
    double getFrequency();
    double getWavelength();
    double getValue(double time);
    void printInfo();
}
