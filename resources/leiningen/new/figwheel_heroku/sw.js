self.addEventListener('install', function(e) {
  console.log('[ServiceWorker] Install');
  e.waitUntil(
    caches.open('{{raw-name}}').then(function(cache) {
      return cache.addAll([
	'/',
	'/css/styles.css',
	'/js/main.js'
      ]);
    })
  );
});

self.addEventListener('fetch', function(event) {
  console.log(`[ServiceWorker] fetch ${event.request.url}`);
  event.respondWith(
    caches.match(event.request).then(function(response) {
      return response || fetch(event.request);
    })
  );
});
