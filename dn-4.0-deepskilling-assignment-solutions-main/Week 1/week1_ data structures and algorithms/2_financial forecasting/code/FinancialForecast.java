public class FinancialForecast {

    // Recursive method to calculate future value
    public static double forecastValue(double principal, double rate, int years) {
        if (years == 0) {
            return principal;
        }
        return forecastValue(principal * (1 + rate), rate, years - 1);
    }

    // Optimized version using memoization (optional enhancement)
    public static double forecastMemo(double principal, double rate, int years, double[] memo) {
        if (years == 0) return principal;
        if (memo[years] != 0) return memo[years];
        memo[years] = forecastMemo(principal * (1 + rate), rate, years - 1, memo);
        return memo[years];
    }

    public static void main(String[] args) {
        double initialInvestment = 10000.0;
        double annualGrowthRate = 0.07;
        int forecastYears = 10;

        double futureValue = forecastValue(initialInvestment, annualGrowthRate, forecastYears);
        System.out.printf("Predicted Future Value (Recursive): %.2f\n", futureValue);

        double[] memo = new double[forecastYears + 1];
        double futureValueMemo = forecastMemo(initialInvestment, annualGrowthRate, forecastYears, memo);
        System.out.printf("Predicted Future Value (Memoized): %.2f\n", futureValueMemo);
    }
}
