package com.midterm;
import Signal;

public class ContinuousSignal implements Signal {
    private double amplitude; // Biên độ
    private double period; // Chu kỳ
    private double frequency; // Tần số
    private double wavelength; // Bước sóng

    public ContinuousSignal(double amplitude, double period, double frequency, double wavelength) {
        this.amplitude = amplitude;
        this.period = period;
        this.frequency = frequency;
        this.wavelength = wavelength;
    }

    public double getAmplitude() {
        return this.amplitude;
    }

    public double getPeriod() {
        return this.period;
    }

    public double getFrequency() {
        return this.frequency;
    }

    public double getWavelength() {
        return this.wavelength;
    }

    public double getValue(double time) {
        int index = (int) (time / this.period) % samples.size(); // Tính chỉ số dựa trên chu kỳ và thời gian
        return samples.get(index);
    }

    public void printInfo() {
        
    }
}