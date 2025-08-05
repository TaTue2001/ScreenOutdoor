  document.addEventListener('DOMContentLoaded', async function () {
      await loadComponent('#tabbar-container', 'components/tabbar.html');

      loadDanhSachPhong();
    
      const saved = localStorage.getItem('selectedPhongId');


      if (saved) {
        document.getElementById('phong-select').value = saved;
        fetchRoom(saved);
      }
    
      document.getElementById('phong-select').addEventListener('change', function () {
        const id = this.value;
        fetchRoom(id);
        localStorage.setItem('selectedPhongId', id); // Lưu ID của phòng được chọn vào localStorage
        toggleMenu();
      });

      setInterval(autoRefreshData, 600000);

    });
    
    function toggleMenu() {
      const menu = document.getElementById('menu-options');
      menu.style.display = menu.style.display === 'block' ? 'none' : 'block';
    }
    
    function showCauHinhPhong() {
      alert("Chức năng cấu hình phòng sẽ phát triển sau.");
    }
    
    function showCauHinhLayout() {
      alert("Chức năng cấu hình layout sẽ phát triển sau.");
    }

    function updateTime() {
      const now = new Date();
      const formatted = now.toLocaleString('vi-VN', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit',
        hour: '2-digit',
        minute: '2-digit',
        second: '2-digit',
      });
      document.getElementById('current-time').textContent = formatted;
    }

    setInterval(updateTime, 1000);


    $(document).ready(function() {
      updateTime();
  });