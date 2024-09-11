package com.exam.app;
import com.exam.app.*;

public class Radar {

    // Phương thức để tính giá trị X(n) theo yêu cầu
    public double getSignalValue(int n) {
        if (n >= 0 && n <= 15) {
            return 1 - (double) n / 15;
        } else {
            return 0; // Khi n không nằm trong khoảng từ 0 đến 15
        }
    }

    // Phương thức in chuỗi tín hiệu từ 0 đến 15
    public void printSignal() {
        for (int n = 0; n <= 15; n++) {
            System.out.println("X(" + n + ") = " + getSignalValue(n));
        }
    }

    // Phương thức chính để chạy ví dụ
    public static void main(String[] args) {
        Radar radar = new Radar();

        // In giá trị tín hiệu X(n) với n = 4
        double valueAtN4 = radar.getSignalValue(4);
        System.out.println("Giá trị tín hiệu X(4) = " + valueAtN4);
    }
}

