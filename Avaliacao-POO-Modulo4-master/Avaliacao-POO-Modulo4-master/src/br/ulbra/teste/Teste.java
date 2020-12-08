package br.ulbra.teste;

import br.ulbra.model.bean.Noticias;
import br.ulbra.model.dao.NoticiasDAO;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author abi
 */
public class Teste {

    public static void main(String[] args) {

        Noticias n = new Noticias();
        NoticiasDAO noticiasDAO = new NoticiasDAO();

        JOptionPane.showMessageDialog(null, "Seja bem-vindo(a) às noticias");

        for (;;) {
            int i = -1;

            i = Integer.parseInt(JOptionPane.showInputDialog("Selecione o que você deseja fazer:  \n"
                    + "1 - Adicionar notícias;\n"
                    + "2 - Editar notícias;\n"
                    + "3 - Excluir notícias;\n"
                    + "4 - Ver notícia(s);\n"
                    + "5 - Sair."));

            if (i == 1) {
                n.setTitulo(JOptionPane.showInputDialog("Digite o título da notícia: "));
                n.setDataPublicacao(JOptionPane.showInputDialog("Digite a data de publicação da notícia: "));
                n.setNoticias(JOptionPane.showInputDialog("Digite a notícia: "));
                noticiasDAO.save(n);
                for (;;) {
                    i = -1;
                    i = Integer.parseInt(JOptionPane.showInputDialog("Deseja adicionar mais uma notícia?\n"
                            + "1 - Sim;\n"
                            + "2 - Não;"));
                    if (i == 1) {
                        n.setTitulo(JOptionPane.showInputDialog("Digite o título da notícia: "));
                        n.setDataPublicacao(JOptionPane.showInputDialog("Digite a data de publicação da notícia: "));
                        n.setNoticias(JOptionPane.showInputDialog("Digite a notícia: "));
                        noticiasDAO.save(n);
                    }
                    if (i == 2) {
                        break;
                    }
                }
            }
            if (i == 2) {
                String resultado = "Lista de notícas\n --------------------------------\n ";
                for (Noticias p : noticiasDAO.findAll()) {
                    resultado += p.getId() + "-" + p.getTitulo() + "\n";
                }
                n.setId(Integer.parseInt(JOptionPane.showInputDialog(null, resultado + "\n Qual notícia você deseja alterar?")));
                n.setTitulo(JOptionPane.showInputDialog("Digite o novo título da notícia: "));
                n.setDataPublicacao(JOptionPane.showInputDialog("Digite a nova data de publicação da notícia: "));
                n.setNoticias(JOptionPane.showInputDialog("Digite a notícia: "));
                noticiasDAO.save(n);
                for (;;) {
                    i = Integer.parseInt(JOptionPane.showInputDialog("Deseja editar mais uma notícia?\n"
                            + "1 - Sim;\n"
                            + "2 - Não;"));

                    if (i == 1) {
                        resultado = "Lista de notícas\n --------------------------------\n ";
                        for (Noticias p : noticiasDAO.findAll()) {
                            resultado += p.getId() + "-" + p.getTitulo() + "\n";
                        }
                        n.setId(Integer.parseInt(JOptionPane.showInputDialog(null, resultado + "\n Qual notícia você deseja alterar?")));
                        n.setTitulo(JOptionPane.showInputDialog("Digite o novo título da notícia: "));
                        n.setDataPublicacao(JOptionPane.showInputDialog("Digite a nova data de publicação da notícia: "));
                        n.setNoticias(JOptionPane.showInputDialog("Digite a notícia: "));
                        noticiasDAO.save(n);
                    }
                    if (i == 2) {
                        break;
                    }
                }
            }

            if (i == 3) {
                String resultado = "Lista de notícas\n --------------------------------\n ";
                for (Noticias p : noticiasDAO.findAll()) {
                    resultado += p.getId() + "-" + p.getTitulo() + "\n";
                }
                n.setId(Integer.parseInt(JOptionPane.showInputDialog(null, resultado + "\n Qual notícia você deseja excluir?")));
                noticiasDAO.remove(n.getId());

                for (;;) {
                    i = Integer.parseInt(JOptionPane.showInputDialog("Deseja excluir mais alguma notícia?\n"
                            + "1 - Sim;\n"
                            + "2 - Não;"));

                    if (i == 1) {
                        resultado = "Lista de notícas\n --------------------------------\n ";
                        for (Noticias p : noticiasDAO.findAll()) {
                            resultado += p.getId() + "-" + p.getTitulo() + "\n";
                        }
                        n.setId(Integer.parseInt(JOptionPane.showInputDialog(null, resultado + "\n Qual notícia você deseja excluir?")));
                        noticiasDAO.remove(n.getId());
                    }
                    if (i == 2) {
                        break;
                    }
                }
            }

            if (i == 4) {
                String resultado = "Lista de notícas\n --------------------------------\n"
                        + "0 - Voltar\n\n";
                for (Noticias p : noticiasDAO.findAll()) {
                    resultado += p.getId() + "-" + p.getTitulo() + "\n";
                }
                for (;;) {
                    int id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\n Qual item você deseja ver com mais detalhes?"));
                    if(id == 0){
                        break;
                    }
                    n = noticiasDAO.findById(id);
                    JOptionPane.showMessageDialog(null,
                            "Título: " + n.getTitulo() + "\n Data de publicação: " + n.getDataPublicacao() + "\n Notícia: " + n.getNoticias());
                }
            }
            
            if (i == 5) {
                break;
            }
        }
    }
}
