
package adicional;

import java.text.DecimalFormat;

public class Cpf {

    public boolean cfp(String texto) {
        String cpf = texto;
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        int soma = 0, temp = 0;
        String resul;
        System.out.println(cpf);

        int j = 0;
        for (int i = 10; i >= 2; i--) {
            soma += (Integer.parseInt(cpf.charAt(j) + "")) * i;
            j++;
        }
        if (soma % 11 < 2) {
            System.out.println("0");
            resul = "0";
        } else {
            temp = 11 - (soma % 11);
            System.out.println(11 - (soma % 11));
            resul = (11 - (soma % 11)) + "";
        }
        soma = 0;
        j = 0;
        for (int i = 11; i >= 2; i--) {
            soma += (Integer.parseInt(cpf.charAt(j) + "")) * i;
            j++;
        }
        if (soma % 11 < 2) {
            System.out.println("0");
            resul += "0";
        } else {
            temp = 11 - (soma % 11);
            System.out.println(11 - (soma % 11));
            resul += (11 - (soma % 11)) + "";;
        }
        DecimalFormat df = new DecimalFormat("00");

        int control;
        control = Integer.parseInt(cpf.substring(9, 11));
        System.out.println(df.format(control));
        System.out.println(resul);

        if (Integer.parseInt(resul) == control) {
            return true;
        } else {
            return false;
        }

    }

}
