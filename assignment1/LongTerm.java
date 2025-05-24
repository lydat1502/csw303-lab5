package assignment1;
public class LongTerm implements Contract{
    private String ContractID;
    private String PropertyID;
    private String TenantID;
    private String RentAmountID;

    @Override
    public void BuildContractID(String ContractID) {
        this.ContractID = ContractID;
        System.out.println("ContractID: "+ContractID);
    }
    @Override
    public void BuildPropertyID(String PropertyID) {
        this.PropertyID = PropertyID;
        System.out.println("PropertyID: "+PropertyID);
    }
    @Override
    public void BuildTenantID(String TenantID) {
        this.TenantID = TenantID;
        System.out.println("TenantID: "+TenantID);
    }
    @Override
    public void BuildRentAmountID(String RentAmountID) {
        this.RentAmountID = RentAmountID;
        System.out.println("RentAmountID: "+RentAmountID);
    }
    @Override
    public Contract SignContract() {
       return new LongTerm();
    }
    
}
