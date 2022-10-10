public class playerSetup {
private int hp;

    public playerSetup(int hp){

        this.hp = hp;

    }

    public void setHp(){

        if(hp < 0 ){

            this.hp = 0;
        
        }

        
    }


    public int getHp(){

    return hp;

    }



}
