package Currency_RecruitmentTask;

public class Patterns {
    double[] data;
    int size;

    public Patterns(double[] data, int size) {
        this.data = data;
        this.size = size;
    }

    double getMid() {
        double sum = 0.0;
        for (double a : data)
            sum += a;
        return sum / size;
    }

    double getVariance() {
        double mid = getMid();
        double temp = 0;
        for (double a : data)
            temp += (a - mid) * (a - mid);
        return temp / size;
    }

    double getStandardDeviation() {
        return Math.sqrt(getVariance());
    }
}
