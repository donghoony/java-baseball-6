package baseball.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }

    public List<Integer> generateUniqueNumbers(int startInclusive, int endInclusive, int size) {
        List<Integer> pickedNumbers = new ArrayList<>();
        while (pickedNumbers.size() != size) {
            int pickedNumber = generate(startInclusive, endInclusive);
            if (pickedNumbers.contains(pickedNumber)) {
                continue;
            }
            pickedNumbers.add(pickedNumber);
        }
        return pickedNumbers;
    }
}
