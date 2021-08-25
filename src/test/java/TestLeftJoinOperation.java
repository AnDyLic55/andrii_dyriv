import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TestLeftJoinOperation {
    @Test
    public void testJoin() throws Exception {
        Collection<DataRow<Integer, String>> leftCollection = new ArrayList<>();
        Collection<DataRow<Integer, String>> rightCollection = new ArrayList<>();

        leftCollection.add(new DataRow<>(0, "Ukraine"));
        leftCollection.add(new DataRow<>(1, "Germany"));
        leftCollection.add(new DataRow<>(2, "France"));

        rightCollection.add(new DataRow<>(0, "Kyiv"));
        rightCollection.add(new DataRow<>(1, "Berlin"));
        rightCollection.add(new DataRow<>(3, "Budapest"));

        LeftJoinOperation<Integer, String, String> leftJoin = new LeftJoinOperation<>();
        Collection<JoinedDataRow<Integer, String, String>> leftJoinResult = leftJoin.join(leftCollection, rightCollection);

        Collection<JoinedDataRow<Integer, String, String>> answer = new ArrayList<>();
        answer.add(new JoinedDataRow<>(0, "Ukraine", "Kyiv"));
        answer.add(new JoinedDataRow<>(1, "Germany", "Berlin"));
        answer.add(new JoinedDataRow<>(2, "France", null));
        Assert.assertEquals(leftJoinResult, answer);
    }
}
