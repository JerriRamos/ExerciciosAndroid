package com.aula.appexame;

public class Aluno {

        private String name;
        private String avaliacao;
        private String media;


        public Aluno(String name, String avaliacao, String media) {
            this.name = name;
            this.avaliacao = avaliacao;
            this.media = media;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getAvaliacao() {
            return avaliacao;
        }
        public void setAvaliacao(String avaliacao) {
            this.avaliacao = avaliacao;
        }

        public String getMedia() {
            return media;
        }
        public void setTest1(String media) {
            this.media = media;
        }


}
