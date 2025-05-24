public interface Contract {
    void BuildContractID(String ContractID);
    void BuildPropertyID(String PropertyID);
    void BuildTenantID(String TenantID);
    void BuildRentAmountID(String RentAmountID);
    Contract SignContract();
}