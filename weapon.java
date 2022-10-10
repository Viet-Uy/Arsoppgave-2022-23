public class weapon {
    private String weapon;
    private int weaponDamage;

    public weapon(String weapon, int weaponDamage){

        this.weapon = weapon;

        this.weaponDamage = weaponDamage;


    }

    public void setDamage(){

        if(weaponDamage < 0){
            this.weaponDamage = 0;
        
        }

    }

    public String getWeapon(){

        return weapon;
    }

    public int getWeaponDamage(){

        return weaponDamage;
    }



}
