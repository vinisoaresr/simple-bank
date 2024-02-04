package dev.vinicius.simplebank.application.usecases;

public interface UseCase<I, O> {

  O execute(I input);

}
