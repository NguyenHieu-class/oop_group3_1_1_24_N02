package com.exam.app;
import com.exam.app.Signal;

public class DiscreteSignal implements Signal {
    private double[] signal;  // Mảng giá trị của tín hiệu tại các điểm thời gian
    private double amplitude;
    private double period;
    private double frequency;
    private double wavelength;

    // Constructor để khởi tạo tín hiệu với các thông số
    public DiscreteSignal(double[] signal, double amplitude, double period, double frequency, double wavelength) {
        this.signal = signal;
        this.amplitude = amplitude;
        this.period = period;
        this.frequency = frequency;
        this.wavelength = wavelength;
    }

    // Implement các phương thức từ interface Signal
    @Override
    public double getAmplitude() {
        return amplitude;
    }

    @Override
    public double getPeriod() {
        return period;
    }

    @Override
    public double getFrequency() {
        return frequency;
    }

    @Override
    public double getWavelength() {
        return wavelength;
    }

    @Override
    public double getValue(double time) {
        // Giả sử tín hiệu lặp lại và tín hiệu chỉ có trong khoảng [0, signal.length)
        int index = (int) (time % signal.length);
        return signal[index];
    }

    @Override
    public void printInfo() {
        System.out.println("Amplitude: " + getAmplitude());
        System.out.println("Period: " + getPeriod());
        System.out.println("Frequency: " + getFrequency());
        System.out.println("Wavelength: " + getWavelength());
        System.out.println("Signal values: " + toString());
    }

    // Phương thức xuất tín hiệu ra dạng chuỗi
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < signal.length; i++) {
            sb.append(signal[i]);
            if (i < signal.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        double[] sampleSignal = { 1.0, 2.0, 3.0, 4.0 };
        DiscreteSignal ds = new DiscreteSignal(sampleSignal, 4.0, 2.0, 50.0, 0.5);

        // Hiển thị thông tin tín hiệu
        ds.printInfo();

        // Lấy giá trị của tín hiệu tại thời gian t = 2.5
        double valueAtTime = ds.getValue(2.5);
        System.out.println("Signal value at time 2.5: " + valueAtTime);
    }
}
