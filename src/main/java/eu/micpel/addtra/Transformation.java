package eu.micpel.addtra;

import java.util.ArrayList;
import java.util.List;

public class Transformation<S, T> {

    private List<Transformer<S, T>> transformers = new ArrayList<>();

    private Transformation(Transformer<S, T> transformer) {
        transformers.add(transformer);
    }

    public static <S, T> Transformation<S, T> tryUsing(Transformer<S, T> transformer) {
        return new Transformation<>(transformer);
    }

    public Transformation<S, T> thenUsing(Transformer<S, T> transformer) {
        transformers.add(transformer);
        return this;
    }

    public T givenInput(S source) throws NoSuitableTransformerException {
        for (var transformer : transformers) {
            try {
                return transformer.tryToTransform(source).orElseThrow(NotApplicableException::new);
            } catch (NotApplicableException e) {
                continue;
            }
        }

        throw new NoSuitableTransformerException();
    }

    static final class NoSuitableTransformerException extends RuntimeException {
        private NoSuitableTransformerException() {
        }
    }

    static final class NotApplicableException extends RuntimeException {
        private NotApplicableException() {
        }
    }
}
