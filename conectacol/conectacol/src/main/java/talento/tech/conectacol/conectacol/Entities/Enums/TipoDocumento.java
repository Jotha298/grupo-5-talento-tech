package talento.tech.conectacol.conectacol.Entities.Enums;

public enum TipoDocumento {
    CEDULA_CIUDADANIA("CC"),
    TARJETA_IDENTIDAD("TI"),
    CEDULA_EXTRANJERIA("CE"),
    PASAPORTE("PAS"),
    REGISTRO_CIVIL("RC"),
    NIT("NIT");

    private final String codigo;

    TipoDocumento(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return this.name() + " (" + codigo+")";

    }
    }
