

let lastScroll = 0;
const navbar = document.getElementById('navbar');

window.addEventListener('scroll', () => {
    const currentScroll = window.pageYOffset;

    if (currentScroll <= 0) {
        navbar.style.top = '0';
        return;
    }

    if (currentScroll > lastScroll) {
      
        navbar.style.top = '-80px'; 
    } else {
       
        navbar.style.top = '0';
    }

    lastScroll = currentScroll;
});


(function(){
  const openers = document.querySelectorAll('[data-open="loginModal"], .login-icon a, .nav-icon'); // common selectors
  const modal = document.getElementById('loginModal');
  const panel = document.getElementById('loginPanel');

  if (!modal || !panel) return;

  function openModal() {
    modal.style.display = 'flex';
    modal.setAttribute('aria-hidden', 'false');
    // focus first email field if present
    setTimeout(()=>{
      const email = modal.querySelector('#emailInput, input[type="email"]');
      if (email) email.focus();
    }, 60);
    document.addEventListener('keydown', onKeyDown);
  }
  function closeModal() {
    modal.style.display = 'none';
    modal.setAttribute('aria-hidden', 'true');
    document.removeEventListener('keydown', onKeyDown);
  }
  function onKeyDown(e){
    if (e.key === 'Escape') closeModal();
  }

  // click outside to close
  modal.addEventListener('click', (e)=> { if (e.target === modal) closeModal(); });
  // stop propagation inside panel
  panel.addEventListener('click', e => e.stopPropagation());

  // attach handlers to anything that should open the login
  document.querySelectorAll('[data-open="loginModal"]').forEach(el=>{
    el.addEventListener('click', (ev)=>{ ev.preventDefault(); openModal(); });
    el.addEventListener('keydown', (ev)=>{ if (ev.key==='Enter' || ev.key===' ') { ev.preventDefault(); openModal(); } });
  });
})();