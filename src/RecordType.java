public class RecordType {
    private boolean admReq;
    private boolean brakeTestReady;
    private boolean brakeTestActive;
    private boolean brakeTestBrake;
    private boolean controlEngaged;
    private boolean controlDriving;
    private boolean controlBraking;
    private boolean standStillDetected;
    private boolean controlLocalized;
    private boolean controlOnMission;
    private boolean controlLocalizedOnMission;
    private boolean drivingForward;
    private boolean activeCabA;
    private boolean activeCabB;
    private boolean ebSignaled;
    private boolean controlArrived;
    private boolean doorsClosedLocked;
    private boolean controlDwelling;
    private int controlValue;
    private int velocity;
    private int trainLength;
    private long lrbg;
    private int position;
    private int controlStatus;
    private long missionStartTP;
    private long missionStartPos;
    private int missionStartDate;
    private long missionStartTime;
    private long missionEndTP;
    private long missionEndPos;
    private int missionEndDate;
    private long missionEndTime;
    private long jppos;
    private int tdwell;
    private boolean deviceActive;
    private boolean admRel;
    private boolean admAct;
    private boolean controlRel;
    private boolean controlDrvRel;
    private boolean ebAct;
    private int trainId;
    private String driverId;

    // Constructor and toString() method for displaying the object
    public RecordType(boolean admReq, boolean brakeTestReady, boolean brakeTestActive, boolean brakeTestBrake,
                      boolean controlEngaged, boolean controlDriving, boolean controlBraking, boolean standStillDetected,
                      boolean controlLocalized, boolean controlOnMission, boolean controlLocalizedOnMission, boolean drivingForward,
                      boolean activeCabA, boolean activeCabB, boolean ebSignaled, boolean controlArrived, boolean doorsClosedLocked,
                      boolean controlDwelling, int controlValue, int velocity, int trainLength, long lrbg, int position,
                      int controlStatus, long missionStartTP, long missionStartPos, int missionStartDate,
                      long missionStartTime, long missionEndTP, long missionEndPos, int missionEndDate,
                      long missionEndTime, long jppos, int tdwell) {
        this.admReq = admReq;
        this.brakeTestReady = brakeTestReady;
        this.brakeTestActive = brakeTestActive;
        this.brakeTestBrake = brakeTestBrake;
        this.controlEngaged = controlEngaged;
        this.controlDriving = controlDriving;
        this.controlBraking = controlBraking;
        this.standStillDetected = standStillDetected;
        this.controlLocalized = controlLocalized;
        this.controlOnMission = controlOnMission;
        this.controlLocalizedOnMission = controlLocalizedOnMission;
        this.drivingForward = drivingForward;
        this.activeCabA = activeCabA;
        this.activeCabB = activeCabB;
        this.ebSignaled = ebSignaled;
        this.controlArrived = controlArrived;
        this.doorsClosedLocked = doorsClosedLocked;
        this.controlDwelling = controlDwelling;
        this.controlValue = controlValue;
        this.velocity = velocity;
        this.trainLength = trainLength;
        this.lrbg = lrbg;
        this.position = position;
        this.controlStatus = controlStatus;
        this.missionStartTP = missionStartTP;
        this.missionStartPos = missionStartPos;
        this.missionStartDate = missionStartDate;
        this.missionStartTime = missionStartTime;
        this.missionEndTP = missionEndTP;
        this.missionEndPos = missionEndPos;
        this.missionEndDate = missionEndDate;
        this.missionEndTime = missionEndTime;
        this.jppos = jppos;
        this.tdwell = tdwell;
    }

    public RecordType(boolean deviceActive, boolean admRel, boolean admAct, boolean controlRel,
                      boolean controlDrvRel, boolean ebAct, boolean brakeTestActive,
                      boolean brakeTestBrake, int trainId, String driverId) {
        // Initialize only the fields specific to DEVICE.CONTROL.Stat
        this.deviceActive = deviceActive;
        this.admRel = admRel;
        this.admAct = admAct;
        this.controlRel = controlRel;
        this.controlDrvRel = controlDrvRel;
        this.ebAct = ebAct;
        this.brakeTestActive = brakeTestActive;
        this.brakeTestBrake = brakeTestBrake;
        this.trainId = trainId;
        this.driverId = driverId;
    }

    @Override
    public String toString() {
        return "RecordType{" +
                "admReq=" + admReq +
                ", brakeTestReady=" + brakeTestReady +
                ", brakeTestActive=" + brakeTestActive +
                ", brakeTestBrake=" + brakeTestBrake +
                ", controlEngaged=" + controlEngaged +
                ", controlDriving=" + controlDriving +
                ", controlBraking=" + controlBraking +
                ", standStillDetected=" + standStillDetected +
                ", controlLocalized=" + controlLocalized +
                ", controlOnMission=" + controlOnMission +
                ", controlLocalizedOnMission=" + controlLocalizedOnMission +
                ", drivingForward=" + drivingForward +
                ", activeCabA=" + activeCabA +
                ", activeCabB=" + activeCabB +
                ", ebSignaled=" + ebSignaled +
                ", controlArrived=" + controlArrived +
                ", doorsClosedLocked=" + doorsClosedLocked +
                ", controlDwelling=" + controlDwelling +
                ", controlValue=" + controlValue +
                ", velocity=" + velocity +
                ", trainLength=" + trainLength +
                ", lrbg=" + lrbg +
                ", position=" + position +
                ", controlStatus=" + controlStatus +
                ", missionStartTP=" + missionStartTP +
                ", missionStartPos=" + missionStartPos +
                ", missionStartDate=" + missionStartDate +
                ", missionStartTime=" + missionStartTime +
                ", missionEndTP=" + missionEndTP +
                ", missionEndPos=" + missionEndPos +
                ", missionEndDate=" + missionEndDate +
                ", missionEndTime=" + missionEndTime +
                ", jppos=" + jppos +
                ", tdwell=" + tdwell +
                ", deviceActive=" + deviceActive +
                ", admRel=" + admRel +
                ", admAct=" + admAct +
                ", controlRel=" + controlRel +
                ", controlDrvRel=" + controlDrvRel +
                ", ebAct=" + ebAct +
                ", trainId=" + trainId +
                ", driverId='" + driverId + '\'' +

                '}';
    }


}
