package unalcol.agents.examples.labyrinth.teseoeater.jffEater;

import unalcol.agents.Action;
import unalcol.agents.AgentProgram;
import unalcol.agents.Percept;
import unalcol.agents.simulate.util.SimpleLanguage;
import unalcol.types.collection.vector.Vector;

public abstract class TeseoEaterAgentProgram implements AgentProgram{
    protected SimpleLanguage language;
    protected Vector<String> cmd = new Vector<String>();

    public TeseoEaterAgentProgram() {
    }
    
    public void setLanguage(  SimpleLanguage _language ){
        language = _language;
    }

    public void init(){
        cmd.clear();
    }
    
    /*
    "front", "right", "back", "left", "treasure",
                   "resource", "resource-color", "resource-shape", "resource-size", "resource-weight", "resource-type", "energy_level"
    */
    
    public abstract int accion( boolean PF, boolean PD, boolean PA, boolean PI, boolean MT,
            boolean R, boolean[] RA, int E);

    /**
    * execute
    *
    * @param perception Perception
    * @return Action[]
    */
    public Action compute(Percept p){
        if( cmd.size() == 0 ){

        boolean[] RA = new boolean[4];
            
        boolean PF = ( (Boolean) p.getAttribute(language.getPercept(0))).
            booleanValue();
        boolean PD = ( (Boolean) p.getAttribute(language.getPercept(1))).
            booleanValue();
        boolean PA = ( (Boolean) p.getAttribute(language.getPercept(2))).
            booleanValue();
        boolean PI = ( (Boolean) p.getAttribute(language.getPercept(3))).
            booleanValue();
        boolean MT = ( (Boolean) p.getAttribute(language.getPercept(4))).
            booleanValue();
        boolean R = ( (Boolean) p.getAttribute(language.getPercept(5))).
            booleanValue();
        int E = ( (Integer) p.getAttribute(language.getPercept(10))).
                    intValue();
        if(R){
            RA[0] = ( (Boolean) p.getAttribute(language.getPercept(6))).
                booleanValue();
            RA[1] = ( (Boolean) p.getAttribute(language.getPercept(7))).
                booleanValue();
            RA[2] = ( (Boolean) p.getAttribute(language.getPercept(8))).
                booleanValue();
            RA[3] = ( (Boolean) p.getAttribute(language.getPercept(9))).
                booleanValue();
        }

        int d = accion(PF, PD, PA, PI, MT, R, RA, E);
        
        
        if(d == 5){
            cmd.add(language.getAction(4));
        }
        else{
            if (0 <= d && d < 4) {
                for (int i = 1; i <= d; i++) {
                    cmd.add(language.getAction(3)); //rotate
                }
                cmd.add(language.getAction(2)); // advance
            }
            else {
                cmd.add(language.getAction(1)); // die
            }
        }
        }
        
    String x = cmd.get(0);
    cmd.remove(0);
    return new Action(x);
  }

  /**
   * goalAchieved
   *
   * @param perception Perception
   * @return boolean
   */
  public boolean goalAchieved( Percept p ){
    return (((Boolean)p.getAttribute(language.getPercept(4))).booleanValue());
  }
}
