package banking.remote;

import banking.model.AccountSummary;
import banking.model.AuthSession;
import banking.model.LoanDecision;
import banking.model.TransactionEntry;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BankService extends Remote {
    AuthSession login(String username, String password) throws RemoteException;

    void logout(String sessionToken) throws RemoteException;

    void registerNotificationEndpoint(String sessionToken, String host, int port) throws RemoteException;

    List<AccountSummary> getAccounts(String sessionToken) throws RemoteException;

    BigDecimal getAccountBalance(String sessionToken, long accountId) throws RemoteException;

    String transferFunds(String sessionToken, long fromAccountId, long toAccountId, BigDecimal amount, String narrative)
            throws RemoteException;

    LoanDecision requestLoan(String sessionToken, long accountId, BigDecimal amount, int termMonths, String purpose)
            throws RemoteException;

    List<TransactionEntry> getTransactionHistory(String sessionToken, long accountId) throws RemoteException;

    List<String> getAuditTrail(String sessionToken, int limit) throws RemoteException;
}
