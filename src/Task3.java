class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException() {
        super();
    }
}

class Account {
    private String owner;
    private int balance;
    private String accountNumber;

    public Account(String owner, int balance, String accountNumber) {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void transfer(int amount) throws NotEnoughMoneyException {
        if (amount > balance) {
            throw new NotEnoughMoneyException();
        }
        balance -= amount;
    }
}

public class Task3 {
    public static void main(String[] args) {
        Account account = new Account("Jan Kowalski", 100, "123456789");
        try {
            account.transfer(500);
        } catch (NotEnoughMoneyException e) {
            System.out.println("NotEnoughMoneyException caught");
        } catch (Exception e) {
            System.out.println("Other exception caught");
        } finally {
            System.out.println(account.getBalance());
        }
    }
}