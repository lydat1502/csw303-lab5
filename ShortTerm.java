public class ShortTerm implements Contract{
    private String ContractID;
    private String RentAmountID;
    private String TenantID;
    private String PropertyID;
    public ShortTerm(String contractID, String rentAmountID, String tenantID, String propertyID) {
        ContractID = contractID;
        RentAmountID = rentAmountID;
        TenantID = tenantID;
        PropertyID = propertyID;
    }
    @Override
    public void BuildContractID() {
       System.out.println("build by ShortTerm with Contract ID: "+ContractID);
    }
    @Override
    public void BuildPropertyID() {
       System.out.println("build by ShortTerm with Property ID: "+PropertyID);
    }
    @Override
    public void BuildTenantID() {
       System.out.println("build by ShortTerm with Tenant ID: "+TenantID);
    }
    @Override
    public void BuildRentAmountID() {
       System.out.println("build by ShortTerm with RentAmount ID: "+RentAmountID);
    }
    @Override
    public Contract SignContract() {
        return null;
    }
}
