import java.util.Scanner;

public class DepositCalculator {

    double CalculateComplexPercent(double depositAmount, double yearRate, int depositPeriod) {
        double pay = depositAmount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }

    double CalculateSimplePercent(double depositAmount, double yearRate, int depositPeriod) {
        return round(depositAmount + depositAmount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateProfit() {
        int depositPeriod;
        int depositType;
        int depositAmount;
        double depositProfit = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        switch (depositType) {
            case 1 : depositProfit = CalculateSimplePercent(depositAmount, 0.06, depositPeriod);
            case 2 : depositProfit = CalculateComplexPercent(depositAmount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod + " лет превратятся в " + depositProfit);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateProfit();
    }
}
