class Bank {
    int n;
    long[] balance;

    public Bank(long[] balance) {
        n = balance.length;
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!isValid(account1) || !isValid(account2) || balance[account1 - 1] < money) {
            return false;
        }

        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!isValid(account)) {
            return false;
        }
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!isValid(account) || balance[account - 1] < money) {
            return false;
        }

        balance[account - 1] -= money;
        return true;
    }

    private boolean isValid(int account) {
        if (account > 0 && account <= n) {
            return true;
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */