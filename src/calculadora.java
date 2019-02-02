public class calculadora implements iCalculadora {

    @Override
    public double sumar(double a, double b) {
        return (a + b);
    }

    @Override
    public double restar(double a, double b) {
        return (b-a);
    }

    @Override
    public double dividir(double b, double a) {
        return (a/b);
    }

    @Override
    public double multiplicar(double a, double b) {
        return (a*b);
    }
}
