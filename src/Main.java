//Calculating VLSM values
import java.util.Scanner;

public class Main {
    public static double cidrPrefix = 0.0;
    public static int howManyHosts = 0, localUsableHostBits = 0;
    public static final double base2 = 2.0, totalBits = 32.0;

    public static void main(String[] args) {
        Scanner getHostBits = new Scanner(System.in);

        System.out.println("Please enter the subnet mask CIDR Prefix Notation value:");
        System.out.println("(Example: for a /27 prefix input 27)");
        cidrPrefix = getHostBits.nextDouble();

        findNumOfHostIPAddresses();
        output();
    }
    //1) How many Hosts
    public static int findNumOfHostIPAddresses(){
        localUsableHostBits = (int)(totalBits - cidrPrefix);
        double localVar = Math.pow(base2, localUsableHostBits) ;
        howManyHosts = (int)localVar;
        return howManyHosts - 2;
    }
    public static void output(){
        System.out.println("With "+localUsableHostBits+" host bits you have enough IP addresses for "+howManyHosts+" host devices.");
        System.out.println("2 of the "+howManyHosts+" IPs have been set a side for the Network ID and Broadcast IP.");
    }
}