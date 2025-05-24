public class Client {
    public static void main(String[] args) {
        System.out.println("\n-permanent: ");
        Contract permanent = new Permanent();
        permanent.BuildContractID("PM001");
        permanent.BuildPropertyID("R001");
        permanent.BuildTenantID("T001");
        permanent.BuildRentAmountID("P001");

        System.out.println("\n-shortTerm: ");
        Contract shortTerm = new ShortTerm();
        shortTerm.BuildContractID("PM002");
        shortTerm.BuildPropertyID("R002");
        shortTerm.BuildTenantID("T002");
        shortTerm.BuildRentAmountID("P002");

        System.out.println("\n-longTerm: ");
        Contract longTerm = new LongTerm();
        longTerm.BuildContractID("PM003");
        longTerm.BuildPropertyID("R003");
        longTerm.BuildTenantID("T003");
        longTerm.BuildRentAmountID("P003");
       
    }
}
