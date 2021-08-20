import components.DataRow;
import components.JoinedDataRow;
import joiners.InnerJoinOperation;
import joiners.LeftJoinOperation;
import joiners.RightJoinOperation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Set<DataRow<Integer, String>> leftCollection = new HashSet<>();
        Set<DataRow<Integer, String>> rightCollection = new HashSet<>();

        leftCollection.add(new DataRow<>(0, "Ukraine"));
        leftCollection.add(new DataRow<>(1, "Germany"));
        leftCollection.add(new DataRow<>(2, "France"));

        rightCollection.add(new DataRow<>(0, "Kyiv"));
        rightCollection.add(new DataRow<>(1, "Berlin"));
        rightCollection.add(new DataRow<>(3, "Budapest"));

        InnerJoinOperation<Integer, String, String> innerJoin = new InnerJoinOperation<>();
        Collection<JoinedDataRow<Integer, String, String>> innerJoinResult =
                innerJoin.join(leftCollection, rightCollection);

        LeftJoinOperation<Integer, String, String> leftJoin = new LeftJoinOperation<>();
        ArrayList<JoinedDataRow<Integer, String, String>> leftJoinResult =
                (ArrayList<JoinedDataRow<Integer, String, String>>) leftJoin.join(leftCollection, rightCollection);

        RightJoinOperation<Integer, String, String> rightJoin = new RightJoinOperation<>();
        ArrayList<JoinedDataRow<Integer, String, String>> rightJoinResult =
                (ArrayList<JoinedDataRow<Integer, String, String>>) rightJoin.join(leftCollection, rightCollection);

        System.out.println("--- InnerJoinOperation ---");
        for (JoinedDataRow<Integer, String, String> item : innerJoinResult) {
            System.out.println(item);
        }

        System.out.println("--- LeftJoinOperation ---");
        for (JoinedDataRow<Integer, String, String> item : leftJoinResult) {
            System.out.println(item);
        }

        System.out.println("--- RightJoinOperation ---");
        for (JoinedDataRow<Integer, String, String> item : rightJoinResult) {
            System.out.println(item);
        }
    }
}
