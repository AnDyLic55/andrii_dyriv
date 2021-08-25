import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class LeftJoinOperation<K, V1, V2> implements JoinOperation<DataRow<K, V1>, DataRow<K, V2>, JoinedDataRow<K, V1, V2>> {
    @Override
    public Collection<JoinedDataRow<K, V1, V2>> join(Collection<DataRow<K, V1>> leftCollection, Collection<DataRow<K, V2>> rightCollection) {
        Collection<JoinedDataRow<K, V1, V2>> result = new ArrayList<>();

        for(DataRow<K, V1> leftItem: leftCollection) {
            boolean found = false;

            for(DataRow<K, V2> rightItem: rightCollection) {
                if(leftItem.getKey() == rightItem.getKey()) {
                    result.add(new JoinedDataRow<>(leftItem.getKey(), leftItem.getValue(), rightItem.getValue()));
                    found = true;
                    break;
                }
            }

            if(!found) {
                result.add(new JoinedDataRow<>(leftItem.getKey(), leftItem.getValue(), null));
            }
        }

        return result;
    }
}
