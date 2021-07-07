package BankDates.AcountUser;

public class BankData {

    private final int userNumberAcount;
    private String userName;
    private double totalBalance;

    public BankData(int userNumberAcount, String userName) {
        this.userNumberAcount = userNumberAcount;
        this.userName = userName;
        this.totalBalance = 0;
    }

    public void addDeposit(double depositValue) {
        this.totalBalance = totalBalance + depositValue ;
    }

    public void withDraw(double withDrawValue){

        if(withDrawValue + 5 >= totalBalance ) {
            System.out.println("Your withdrawal is greater than your balance");
            return;
        }

        if (withDrawValue > 1200.00){
            System.out.println("You can't to withdraw greater than U$ 1,200.00." );
            return;
        }

        totalBalance = totalBalance - withDrawValue - 5;

    }
    public String dataUpdateStr(){
        return "Updated data: \n"
                + "Acount: " + userNumberAcount + " \n"
                + " Holder: " + userName + "\n"
                + " Balance: " + totalBalance;
    }

}
