public class Account {
    private double balance;
    private String accountNumber;

    // Конструктор
    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Метод для поповнення рахунку
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Поповнення на " + amount + " грн виконано успішно.");
        } else {
            System.out.println("Сума поповнення повинна бути більшою за 0.");
        }
    }

    // Метод для зняття коштів
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Знято " + amount + " грн з рахунку.");
        } else if (amount > balance) {
            System.out.println("Недостатньо коштів на рахунку.");
        } else {
            System.out.println("Сума зняття повинна бути більшою за 0.");
        }
    }

    // Метод для перевірки балансу
    public double checkBalance() {
        return balance;
    }

    // Метод для отримання номера рахунку
    public String getAccountNumber() {
        return accountNumber;
    }
    public static void main(String[] args) {
        Account myAccount = new Account("UA1234567890", 1000.0);

        System.out.println("Поточний баланс: " + myAccount.checkBalance() + " грн");
        myAccount.deposit(500.0);
        System.out.println("Поточний баланс: " + myAccount.checkBalance() + " грн");
        myAccount.withdraw(300.0);
        System.out.println("Поточний баланс: " + myAccount.checkBalance() + " грн");
        myAccount.withdraw(1500.0); // Перевірка на недостатній баланс
    }
}
