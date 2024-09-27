package lab_4a;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Bag<E> implements Multiset <E> {

    private final List<E> list = new ArrayList<>();

    @Override
    public void add(E element) {
        list.add(element);
    }

    @Override
    public boolean remove(E element) {
        return list.remove(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public int count(E element) {
        int cnt = 0;
        for (E item : list)
            if (item.equals(element))
                cnt++;
        return cnt;
    }

    @Override
    public Optional<E> grab() {
        return list.isEmpty() ? Optional.empty() : list.stream().findAny();
    }
}
