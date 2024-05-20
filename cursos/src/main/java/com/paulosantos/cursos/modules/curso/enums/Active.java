package com.paulosantos.cursos.modules.curso.enums;

public enum Active {
      CHECK("check"),
      UNCHECK("uncheck");

      private String value;

      Active(String value) {
            this.value = value;
      }

      public String getValue() {
            return value;
      }

}
