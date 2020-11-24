package net.karton.model;


    public final class Views {
        public interface ShortReview {}
        public interface FullReview extends ShortReview {}

        public interface ShortGood extends ShortReview, ShortUser {}
        public interface FullGood extends ShortGood {}

        public interface ShortUser {}
}
