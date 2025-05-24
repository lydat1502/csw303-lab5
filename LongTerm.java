public class LongTerm implements Contract{
    private String ContractID;
    private String PropertyID;
    private String TenantID;
    private String RentAmountID;
    public LongTerm(String contractID, String propertyID, String tenantID, String rentAmountID) {
        ContractID = contractID;
        PropertyID = propertyID;
        TenantID = tenantID;
        RentAmountID = rentAmountID;
    }
    @Override
    public void BuildContractID() {
       System.out.println("build by LongTerm with Contract ID: "+ContractID);
    }
    @Override
    public void BuildPropertyID() {
       System.out.println("build by LongTerm with Property ID: "+PropertyID);
    }
    @Override
    public void BuildTenantID() {
       System.out.println("build by LongTerm with Tenant ID: "+TenantID);
    }
    @Override
    public void BuildRentAmountID() {
       System.out.println("build by LongTerm with RentAmount ID: "+RentAmountID);
    }
    @Override
    public Contract SignContract() {
        return null;
    }
    
}
