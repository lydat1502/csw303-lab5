public interface Contract {
    void BuildContractID();
    void BuildPropertyID();
    void BuildTenantID();
    void BuildRentAmountID();
    Contract SignContract();
}