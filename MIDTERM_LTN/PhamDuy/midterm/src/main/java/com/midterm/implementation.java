package com.midterm;
import Signal;

public class DiscreteSignal implements Signal {
    private Map<Integer, Double> signalValues; // Lưu trữ giá trị của tín hiệu rời rạc x(k)
    
    public DiscreteSignal() {
        signalValues = new HashMap<>();
    }
    
    public void setValue(int k, double value) {
        signalValues.put(k, value);
    }

    public int delta(int n) {
        return (n == 0) ? 1 : 0;
    }
    
    public double calculateSignalAt(int n) {
        double result = 0;
        for (int k : signalValues.keySet()) {
            result += signalValues.get(k) * delta(n - k);
        }
        return result;
    }

    public void displaySignalInfo() {
        System.out.println("Discrete Signal Info:");
        for (int k : signalValues.keySet()) {
            System.out.println("x(" + k + ") = " + signalValues.get(k));
        }
    }
    
    public double getAmplitude() {
        return 0;
    }

    public double getFrequency() {
        return 0; 
    }

    public double getPeriod() {
        return 0; 
    }

    
    public double getWavelength() {
        return 0; 
    }
    
    public static void main(String[] args) {
        // Tạo một tín hiệu rời rạc
        DiscreteSignal signal = new DiscreteSignal();
        
        // Thêm một vài giá trị x(k)
        signal.setValue(-1, 2.0);
        signal.setValue(0, 3.0);
        signal.setValue(1, 1.5);

        // Hiển thị thông tin tín hiệu
        signal.displaySignalInfo();
        
        // Tính toán giá trị của tín hiệu tại x(n) với n = 0
        System.out.println("x(0) = " + signal.calculateSignalAt(0));
    }
}
