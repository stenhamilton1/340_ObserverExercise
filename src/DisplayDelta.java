public class DisplayDelta implements Observer {
    private Flight thisFlight;
    private float oldLongitude = 0;
    private float oldLatitude = 0;
    private float oldVelocity = 0;
    private float oldAltitude = 0;
    private String delta;

    @Override
    public void Update(Flight flight) {
        thisFlight = flight;
        if((this.oldLongitude == 0) && (this.oldLatitude == 0) && (this.oldVelocity == 0)
                && (this.oldAltitude == 0)) {
            InitializeDelta();
        } else {
            Display();
        }
    }

    public void Display() {
        float newLongitude = thisFlight.longitude;
        float newLatitude = thisFlight.latitude;
        float newVelocity = thisFlight.velocity;
        float newAltitude = thisFlight.geo_altitude;

        float deltLong = newLongitude - oldLongitude;
        float deltLat = newLatitude - oldLatitude;
        float deltVel = newVelocity - oldVelocity;
        float deltAlt = newAltitude - oldAltitude;

        this.oldLongitude = newLongitude;
        this.oldLatitude = newLatitude;
        this.oldVelocity = newVelocity;
        this.oldAltitude = newAltitude;

        this.delta = "--- CHANGE || ";
        if(deltLong != 0) {
            this.delta += String.format("lon: %f", deltLong);
        }
        if(deltLat != 0) {
            if(deltLong != 0) {
                this.delta += String.format(", lat: %f", deltLat);
            } else {
                this.delta += String.format("lat: %f", deltLat);
            }
        }
        if(deltVel != 0) {
            if(deltLong != 0 || deltLat != 0){
                this.delta += String.format(", vel: %f", deltVel);
            } else {
                this.delta += String.format("vel: %f", deltVel);
            }
        }
        if(deltAlt != 0){
            if(deltLong != 0 || deltLat != 0 || deltVel != 0){
                this.delta += String.format(", alt: %f", deltAlt);
            } else {
                this.delta += String.format("alt: %f", deltAlt);
            }
        }
        System.out.println(this.delta);
    }

    public void InitializeDelta() {
        if(this.oldLongitude == 0) {
            this.oldLongitude = thisFlight.longitude;
        }
        if(this.oldLatitude == 0) {
            this.oldLatitude = thisFlight.latitude;
        }
        if(this.oldVelocity == 0) {
            this.oldVelocity = thisFlight.velocity;
        }
        if(this.oldAltitude == 0) {
            this.oldAltitude = thisFlight.geo_altitude;
        }
    }
}
