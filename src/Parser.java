import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

public class Parser {

    // Decodes DEVICE.CONTROL.Stat data structure
    public RecordType decodeDeviceControlStat(byte[] rawData) {
        ByteBuffer buffer = ByteBuffer.wrap(rawData);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        // Decode BITSET16 flags (2 bytes)
        int flags = Short.toUnsignedInt(buffer.getShort());
        boolean deviceActive = (flags & (1 << 0)) != 0;
        boolean admRel = (flags & (1 << 1)) != 0;
        boolean admAct = (flags & (1 << 2)) != 0;
        boolean controlRel = (flags & (1 << 3)) != 0;
        boolean controlDrvRel = (flags & (1 << 4)) != 0;
        boolean ebAct = (flags & (1 << 5)) != 0;
        boolean brakeTestActive = (flags & (1 << 6)) != 0;
        boolean brakeTestBrake = (flags & (1 << 7)) != 0;

        // Decode BCD32 Train ID (4 bytes)
        int trainId = decodeBCD32(buffer);

        // Decode STRING16 Driver ID (16 bytes)
        String driverId = decodeString16(buffer);

        return new RecordType(deviceActive, admRel, admAct, controlRel, controlDrvRel,
                ebAct, brakeTestActive, brakeTestBrake, trainId, driverId);
    }

    // Decodes CONTROL.DEVICE.Stat data structure
    public RecordType decodeControlDeviceStat(byte[] rawData) {
        ByteBuffer buffer = ByteBuffer.wrap(rawData);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        // Decode BITSET32 flags (4 bytes)
        int flags = buffer.getInt();
        boolean admReq = (flags & (1 << 0)) != 0;
        boolean brakeTestReady = (flags & (1 << 1)) != 0;
        boolean brakeTestActive = (flags & (1 << 2)) != 0;
        boolean brakeTestBrake = (flags & (1 << 3)) != 0;
        boolean controlEngaged = (flags & (1 << 4)) != 0;
        boolean controlDriving = (flags & (1 << 5)) != 0;
        boolean controlBraking = (flags & (1 << 6)) != 0;
        boolean standStillDetected = (flags & (1 << 7)) != 0;
        boolean controlLocalized = (flags & (1 << 8)) != 0;
        boolean controlOnMission = (flags & (1 << 9)) != 0;
        boolean controlLocalizedOnMission = (flags & (1 << 10)) != 0;
        boolean drivingForward = (flags & (1 << 11)) != 0;
        boolean activeCabA = (flags & (1 << 12)) != 0;
        boolean activeCabB = (flags & (1 << 13)) != 0;
        boolean ebSignaled = (flags & (1 << 14)) != 0;
        boolean controlArrived = (flags & (1 << 15)) != 0;
        boolean doorsClosedLocked = (flags & (1 << 16)) != 0;
        boolean controlDwelling = (flags & (1 << 17)) != 0;

        // Decode UINT8 CONTROL control value (1 byte)
        int controlValue = Byte.toUnsignedInt(buffer.get());

        // Decode UINT16 velocity (2 bytes)
        int velocity = Short.toUnsignedInt(buffer.getShort());

        // Decode UINT16 train length (2 bytes)
        int trainLength = Short.toUnsignedInt(buffer.getShort());

        // Decode UINT32 LRBG (Last Relevant Balise Group)
        long lrbg = Integer.toUnsignedLong(buffer.getInt());

        // Decode INT32 position (4 bytes)
        int position = buffer.getInt();

        // Decode UINT8 CONTROL status (1 byte)
        int controlStatus = Byte.toUnsignedInt(buffer.get());

        // Decode mission start and end points (each with 4 fields)
        long missionStartTP = Integer.toUnsignedLong(buffer.getInt());
        long missionStartPos = Integer.toUnsignedLong(buffer.getInt());
        int missionStartDate = Short.toUnsignedInt(buffer.getShort());
        long missionStartTime = Integer.toUnsignedLong(buffer.getInt());

        long missionEndTP = Integer.toUnsignedLong(buffer.getInt());
        long missionEndPos = Integer.toUnsignedLong(buffer.getInt());
        int missionEndDate = Short.toUnsignedInt(buffer.getShort());
        long missionEndTime = Integer.toUnsignedLong(buffer.getInt());

        // Decode UINT32 jppos (Position within JP)
        long jppos = Integer.toUnsignedLong(buffer.getInt());

        // Decode UINT16 tdwell (Dwell time in seconds)
        int tdwell = Short.toUnsignedInt(buffer.getShort());

        return new RecordType(admReq, brakeTestReady, brakeTestActive, brakeTestBrake,
                controlEngaged, controlDriving, controlBraking, standStillDetected,
                controlLocalized, controlOnMission, controlLocalizedOnMission, drivingForward,
                activeCabA, activeCabB, ebSignaled, controlArrived, doorsClosedLocked,
                controlDwelling, controlValue, velocity, trainLength, lrbg, position,
                controlStatus, missionStartTP, missionStartPos, missionStartDate,
                missionStartTime, missionEndTP, missionEndPos, missionEndDate,
                missionEndTime, jppos, tdwell);
    }

    // Helper method to decode BCD32 values (for Train ID)
    private int decodeBCD32(ByteBuffer buffer) {
        int bcdValue = 0;
        for (int i = 0; i < 4; i++) {
            byte b = buffer.get();
            int digit1 = (b >> 4) & 0x0F;
            int digit2 = b & 0x0F;
            bcdValue = bcdValue * 100 + digit1 * 10 + digit2;
        }
        return bcdValue;
    }

    // Helper method to decode STRING16 values (for Driver ID)
    private String decodeString16(ByteBuffer buffer) {
        byte[] stringBytes = new byte[16];
        buffer.get(stringBytes);
        return new String(stringBytes, StandardCharsets.UTF_8).trim();
    }
}
