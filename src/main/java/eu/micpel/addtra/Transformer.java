package eu.micpel.addtra;

import java.util.Optional;

public interface Transformer<S, T> {

    Optional<T> tryToTransform(S source);

}
