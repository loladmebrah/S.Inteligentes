package unalcol.agents.examples.labyrinth.teseoeater.jffCanival;

public class Useless extends TeseoAgentProgramCanival{

    public Useless() {
    }

    @Override
    public int accion(boolean PF, boolean PD, boolean PA, boolean PI, boolean MT, boolean R, boolean[] RA, int E) {
        
        System.out.println("Estado TODO:\nResource: "+R+"\nResource Color: "+RA[0]+"\nResource Shape: "+RA[1]+"\nResource Size: "+RA[2]+"\nResource Weight: "+RA[3]+"\nEnergy Level: "+E);
        
        if (MT) return -1;
        if (!PD) return 1;
        if (!PF) return 0;
        if (!PI) return 3;
        return 2;
    }

}
