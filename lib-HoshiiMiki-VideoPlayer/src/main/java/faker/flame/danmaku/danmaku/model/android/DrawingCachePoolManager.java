
package faker.flame.danmaku.danmaku.model.android;

import faker.flame.danmaku.danmaku.model.android.DrawingCache;
import faker.flame.danmaku.danmaku.model.objectpool.PoolableManager;

public class DrawingCachePoolManager implements PoolableManager<faker.flame.danmaku.danmaku.model.android.DrawingCache> {

    @Override
    public faker.flame.danmaku.danmaku.model.android.DrawingCache newInstance() {
        return null;
    }

    @Override
    public void onAcquired(faker.flame.danmaku.danmaku.model.android.DrawingCache element) {

    }

    @Override
    public void onReleased(DrawingCache element) {

    }

}
