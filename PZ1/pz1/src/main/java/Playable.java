public interface Playable {
    void play();
    public static void main(String[] args) {
        Playable guitar = new Guitar();
        Playable piano = new Piano();

        guitar.play();  // Виведе: Гітара грає мелодійні акорди.
        piano.play();   // Виведе: Піаніно грає класичну композицію.
    }
}
