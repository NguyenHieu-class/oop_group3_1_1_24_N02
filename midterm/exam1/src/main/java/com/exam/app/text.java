public interface Signal {
    // Các thuộc tính của tín hiệu
    double getAmplitude();  // Biên độ
    double getPeriod();     // Chu kỳ
    double getFrequency();  // Tính thường xuyên
    double getWavelength(); // Bước sóng

    // Phương thức lấy giá trị tín hiệu tại thời điểm t
    double getValue(double time);

    // Phương thức in thông tin tín hiệu
    void printInfo();
}


public class DiscreteSignal implements Signal {
    private double amplitude;
    private double period;
    private double frequency;
    private double wavelength;
    private List<Double> samples; // Lưu các giá trị tín hiệu rời rạc

    public DiscreteSignal(double amplitude, double period, double frequency, double wavelength, List<Double> samples) {
        this.amplitude = amplitude;
        this.period = period;
        this.frequency = frequency;
        this.wavelength = wavelength;
        this.samples = samples;
    }

    @Override
    public double getAmplitude() {
        return this.amplitude;
    }

    @Override
    public double getPeriod() {
        return this.period;
    }

    @Override
    public double getFrequency() {
        return this.frequency;
    }

    @Override
    public double getWavelength() {
        return this.wavelength;
    }

    // Lấy giá trị tín hiệu rời rạc tại thời điểm t
    @Override
    public double getValue(double time) {
        int index = (int) (time / this.period) % samples.size(); // Tính chỉ số dựa trên chu kỳ và thời gian
        return samples.get(index);
    }

    @Override
    public void printInfo() {
        System.out.println("Tín hiệu rời rạc:");
        System.out.println("Biên độ: " + amplitude + ", Chu kỳ: " + period + ", Tính thường xuyên: " + frequency + ", Bước sóng: " + wavelength);
        System.out.println("Mẫu tín hiệu: " + samples);
    }
}

public class ContinuousSignal implements Signal {
    private double amplitude;
    private double period;
    private double frequency;
    private double wavelength;

    public ContinuousSignal(double amplitude, double period, double frequency, double wavelength) {
        this.amplitude = amplitude;
        this.period = period;
        this.frequency = frequency;
        this.wavelength = wavelength;
    }

    @Override
    public double getAmplitude() {
        return this.amplitude;
    }

    @Override
    public double getPeriod() {
        return this.period;
    }

    @Override
    public double getFrequency() {
        return this.frequency;
    }

    @Override
    public double getWavelength() {
        return this.wavelength;
    }

    // Tín hiệu liên tục có giá trị thay đổi theo thời gian
    @Override
    public double getValue(double time) {
        return amplitude * Math.sin(2 * Math.PI * frequency * time);
    }

    @Override
    public void printInfo() {
        System.out.println("Tín hiệu liên tục:");
        System.out.println("Biên độ: " + amplitude + ", Chu kỳ: " + period + ", Tính thường xuyên: " + frequency + ", Bước sóng: " + wavelength);
    }
}


