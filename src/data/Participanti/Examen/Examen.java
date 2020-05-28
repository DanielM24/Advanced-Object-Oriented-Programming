package data.Participanti.Examen;

public class Examen {
    private Float nota_examen;
    private int sala_examen;
    private int legitimatie_concurs_id;

    public Examen(int legitimatie_concurs_id, int sala_examen, Float nota_examen) {
        this.legitimatie_concurs_id = legitimatie_concurs_id;
        this.sala_examen = sala_examen;
        this.nota_examen = nota_examen;
    }

    public int get_legitimatie_concurs_id() { return legitimatie_concurs_id; }

    public void set_legitimatie_concurs_id(int legitimatie_concurs_id) { this.legitimatie_concurs_id = legitimatie_concurs_id; }

    public int get_sala_examen() { return sala_examen; }

    public void set_sala_examen(int sala_examen) {this.sala_examen = sala_examen; }

    public Float get_nota_examen() { return nota_examen; }

    public void set_nota_examen(Float nota_examen) { this.nota_examen = nota_examen; }

}