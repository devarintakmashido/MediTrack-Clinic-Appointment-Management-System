package Repositories;

import Entity.BillSummary;
import util.DataStore;

import java.util.List;

public class BillSummaryRepo {
    private static final DataStore<BillSummary> billSummaryDataStore = new DataStore<>();


    public static void addSummary(BillSummary billSummary) {
        billSummaryDataStore.add(billSummary);
    }

    // Get summary by billId
    public static BillSummary getByBillId(String billId) {
        for (BillSummary s : billSummaryDataStore.getAll()) {
            if (s.getBillId().equals(billId)) {
                return s;
            }
        }
        return null;
    }

    // Get all summaries
    public static List<BillSummary> getAllSummaries() {
        return billSummaryDataStore.getAll();
    }
}
